import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class VoronCalc extends JFrame {
    private int voron = 0;
    private int hidie = 0;
    private JLabel countlabel;
    private JButton addCrow;
    private JButton removeCrow;
    private JButton hide;
    public VoronCalc() {
        super("Calculator of crows");
        countlabel = new JLabel("Crows:" + voron);
        addCrow = new JButton("Add crow");
        removeCrow = new JButton("Remove crow");
        hide = new JButton("Hide buttons");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(countlabel, BorderLayout.NORTH);
        buttonsPanel.add(hide);
        buttonsPanel.add(addCrow);
        buttonsPanel.add(removeCrow);

        add(buttonsPanel, BorderLayout.SOUTH);
        setBounds(400, 100, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initListeners();
    }
    private void initListeners() {
        addCrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voron = voron + 1;
                updateCrowCounter();
            }
        });
        removeCrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (voron > 0) {
                    voron = voron - 1;
                }
                updateCrowCounter();
            }
        });
        hide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (hidie == 0) {
                    addCrow.setVisible(false);
                    removeCrow.setVisible(false);
                    hidie = 1;
                }
                else {
                    addCrow.setVisible(true);
                    removeCrow.setVisible(true);
                    hidie = 0;
                }
            }
        });

    }
    private void updateCrowCounter() {
        countlabel.setText("Crows:" + voron);
    }
}
