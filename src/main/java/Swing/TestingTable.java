package Swing;

import Office.Person;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

public class TestingTable {
    private JTable MyTable;
    javax.swing.table.TableColumn ID;
    javax.swing.table.TableColumn Name;
Office.Person person=new Office.Person("12","ax"  );





    public TestingTable() {
        MyTable.addFocusListener( new FocusAdapter() {
            @Override
            public void focusGained( FocusEvent e ) {
                JPopupMenu.getDefaultLightWeightPopupEnabled();
                JPopupMenu.setDefaultLightWeightPopupEnabled( true );
                {
                    List<String> items = new ArrayList<>();
                    items.add( "one" );
                    items.add( "two" );
                }
            }
        } );
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void setData( Office.Person data ) {
        MyTable.addColumn( ID );
        MyTable.addColumn( Name);
    }

    public void getData( Office.Person data ) {
    }

    public boolean isModified( Office.Person data ) {
        return false;
    }
}
