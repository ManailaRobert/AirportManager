package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UnAvailableCrewTableModel extends AbstractTableModel {

    private  CrewList CrewList;
    private List<Crew> UnAvailableCrew;
    private String[] columns ={"Nr","Job","Name","Plane Name","Plane Status"};
    public  UnAvailableCrewTableModel(CrewList crewList){
        CrewList = crewList;
        UnAvailableCrew = CrewList.GetUnAvailableCrewList();
    }
    @Override
    public int getRowCount() {
        return CrewList.GetNrOfUnavailableCrew();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public  String getColumnName(int column){
        return columns[column];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Crew crew = UnAvailableCrew.get(rowIndex);
        switch (columnIndex){
            case 0:
                return  rowIndex+1;
            case 1:
                return  crew.Type;
            case 2:
                return  crew.Name;
            case 3:
                return  crew.getAssignedPlane().GetID();
            case 4:
                return crew.getAssignedPlane().getStatus();
            default:return null;
        }
    }
}
