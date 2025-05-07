package trainsim.ui;

import trainsim.objects.AutonomousTrain;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static trainsim.ui.TrainSimUI.SELECTED_TRAIN;

public class TrainStatusPanel extends JPanel {


    private JTable table;
    private TrainTableModel model;

    public TrainStatusPanel(TrainSimUI ui) {
        setLayout(new BorderLayout());
        setupTable();
        setBorder(BorderFactory.createTitledBorder("Train Status"));


    }

    private void setupTable() {
        this.model = new TrainTableModel();
        this.table = new JTable(model);

        table.setRowHeight(20);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if(row >= 0){
                    SELECTED_TRAIN = model.getTrainAt(row);
                }
            }
        });

        // Add table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void trackTrain(AutonomousTrain train){
        this.model.addTrain(train);

    }



    public void updateView(){
        this.model.updateTrains();
    }
}

class TrainTableModel extends AbstractTableModel {

    private List<AutonomousTrain> trains;
    private String[] columnNames = {"ID", "Status", "Speed (km/s)"};

    public TrainTableModel() {
        this.trains = new ArrayList<>();
    }

    public void addTrain(AutonomousTrain train) {
        // Check if train is already in the list
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getID().equals(train.getID())) {
                trains.set(i, train); // Update existing train
                fireTableRowsUpdated(i, i);
                return;
            }
        }
        // Add new train
        this.trains.add(train);
        fireTableRowsInserted(trains.size() - 1, trains.size() - 1);
    }

    public void updateTrains() {
        for (int i = 0; i < trains.size(); i++) {
            trains.set(i, trains.get(i)); // Update existing train
            fireTableRowsUpdated(i, i);
        }
    }


    @Override
    public int getRowCount() {
        return trains.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AutonomousTrain at = trains.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return at.getID();
            case 1:
                return at.status;
            case 2:
                return at.getCurrentSpeed();
            default:
                return null;
        }
    }

    public AutonomousTrain getTrainAt(int row){
        return trains.get(row);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}