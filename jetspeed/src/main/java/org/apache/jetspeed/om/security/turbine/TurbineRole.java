
package org.apache.jetspeed.om.security.turbine;


import org.apache.torque.om.Persistent;

/** 
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Mon Jun 03 20:14:05 PDT 2002]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class TurbineRole 
    extends org.apache.jetspeed.om.security.turbine.BaseTurbineRole
    implements Persistent, org.apache.jetspeed.om.security.Role
{
    public String getName()
    {
        return getRoleName();
    }

    public void setName(String name)
    {
        setRoleName(name);
    }

    public String getId()
    {
        return String.valueOf(this.getRoleId());
    }

    public void setId(String id)
    {
    }
}
