package trainsim.ui;

import org.jfree.xml.generator.JavaSourceCollector;
import trainsim.TrainSim;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AgentLogPanel extends TrainSimPanel {

    private JTextArea logArea;

    public AgentLogPanel(TrainSimUI ui) {
        super(ui);
        this.logArea = new JTextArea("", 0 ,0);
        this.logArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(logArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        setPreferredSize(new Dimension(500, 150));

        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");
        logArea.append("test\n");

    }



    @Override
    public void update() {

    }
}
