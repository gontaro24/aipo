/*
 * Aipo is a groupware program developed by TOWN, Inc.
 * Copyright (C) 2004-2015 TOWN, Inc.
 * http://www.aipo.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aimluck.eip.modules.screens;

import org.apache.jetspeed.services.logging.JetspeedLogFactoryService;
import org.apache.jetspeed.services.logging.JetspeedLogger;
import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;

import com.aimluck.eip.cayenne.om.security.TurbineUser;
import com.aimluck.eip.common.ALEipConstants;
import com.aimluck.eip.common.ALEipUser;
import com.aimluck.eip.userlist.UserSelectData;
import com.aimluck.eip.userlist.utils.UserListUtils;
import com.aimluck.eip.util.ALEipUtils;

/**
 * ユーザーアカウントの詳細画面を処理するクラスです。 <br />
 *
 */
public class UserPopupScreen extends ALVelocityScreen {

  /** logger */
  private static final JetspeedLogger logger = JetspeedLogFactoryService
    .getLogger(UserPopupScreen.class.getName());

  /**
   *
   * @param rundata
   * @param context
   * @throws Exception
   */
  @Override
  protected void doOutput(RunData rundata, Context context) throws Exception {
    try {
      context.put("globalPortlets", ALEipUtils.getGlobalPortlets(rundata));

      UserSelectData detailData = new UserSelectData();
      detailData.initField();
      detailData.doViewDetail(this, rundata, context);

      String entityid =
        ALEipUtils.getTemp(rundata, context, ALEipConstants.ENTITY_ID);
      context.put(ALEipConstants.ENTITY_ID, entityid);

      ALEipUser user = ALEipUtils.getALEipUser(rundata);
      TurbineUser entity_user =
        ALEipUtils.getTurbineUser(Integer.parseInt(entityid));

      String layout_template = null;
      int userId = 0;
      try {
        userId = Integer.parseInt(entityid);
      } catch (Throwable ignore) {
        //
      }
      if (userId < 4) {
        layout_template = "portlets/html/ajax-userlist-popup-system.vm";
      } else if (String.valueOf(user.getUserId().getValue()).equals(entityid)) {
        layout_template = "portlets/html/ajax-userlist-popup-owner.vm";
      } else if (!(entity_user.getDisabled().equals("F"))) {
        layout_template = "portlets/html/ajax-userlist-popup-disable.vm";
      } else {
        layout_template = "portlets/html/ajax-userlist-popup.vm";
      }
      setTemplate(rundata, context, layout_template);
    } catch (Exception ex) {
      logger.error("[AccountUserDetailScreen] Exception.", ex);
      ALEipUtils.redirectDBError(rundata);
    }
  }

  /**
   * @return
   */
  @Override
  protected String getPortletName() {
    return UserListUtils.USERLIST_PORTLET_NAME;
  }

}
