package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AvailableCrewTableModel extends AbstractTableModel {

    private  CrewList CrewList;
    private List<Crew> AllCrew;
    private String[] columns ={"Nr","Type","Name"};

    public AvailableCrewTableModel(CrewList crewList ){
        CrewList = crewList;
        AllCrew = CrewList.GetAvailableCrewList();
    }

    @Override
    public int getRowCount() {
        return CrewList.GetNrOfAvailableCrew();
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
        Crew crew = AllCrew.get(rowIndex);
        switch (columnIndex){
            case 0:
                return  rowIndex+1;
            case 1:
                return  crew.Type;
            case 2:
                return  crew.Name;
            default:return null;
        }
    }
}
