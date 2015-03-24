package org.apache.jetspeed.om.dbregistry.map;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;

/**
  *  This class was autogenerated by Torque on:
  *
  * [Thu Jun 10 23:17:32 JST 2004]
  *
  */
public class MediatypeMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "org.apache.jetspeed.om.dbregistry.map.MediatypeMapBuilder";


    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public void doBuild() throws TorqueException
    {
        dbMap = Torque.getDatabaseMap("default");

        dbMap.addTable("MEDIATYPE");
        TableMap tMap = dbMap.getTable("MEDIATYPE");

        tMap.setPrimaryKeyMethod(TableMap.NATIVE);

        tMap.setPrimaryKeyMethodInfo("MEDIATYPE");

              tMap.addPrimaryKey("MEDIATYPE.ID", new Long(0));
                    tMap.addColumn("MEDIATYPE.NAME", new String());
                    tMap.addColumn("MEDIATYPE.HIDDEN", new Integer(0));
                    tMap.addColumn("MEDIATYPE.MIMETYPE", new String());
                    tMap.addColumn("MEDIATYPE.ROLE", new String());
                    tMap.addColumn("MEDIATYPE.TITLE", new String());
                    tMap.addColumn("MEDIATYPE.DESCRIPTION", new String());
                    tMap.addColumn("MEDIATYPE.IMAGE", new String());
          }
}
