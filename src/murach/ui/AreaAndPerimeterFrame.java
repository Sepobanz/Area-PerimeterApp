package murach.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import murach.business.Rectangle;

public class AreaAndPerimeterFrame extends JFrame {

    // TODO: Add instance variables for text fields
    private JTextField lengthField; //
    private JTextField widthField; //
    private JTextField areaField; //
    private JTextField perimeterField; //
    private JButton compute;
    private JButton reset;

    public AreaAndPerimeterFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }

    private void initComponents() {
        setTitle("Area and Perimeter Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        
        // components go here
        
        Dimension dim = new Dimension(150, 20); //
        Dimension minDim = new Dimension(30, 20); //

        lengthField = new JTextField(); //
        lengthField.setMinimumSize(minDim); //
        lengthField.setPreferredSize(dim); //
        
        widthField = new JTextField(); //
        widthField.setMinimumSize(minDim); //
        widthField.setPreferredSize(dim); //
        
        areaField = new JTextField(); //
        areaField.setEditable(false); //
        areaField.setMinimumSize(minDim); //
        areaField.setPreferredSize(dim); //
        
        perimeterField = new JTextField(); //
        perimeterField.setEditable(false); //
        perimeterField.setMinimumSize(minDim); //
        perimeterField.setPreferredSize(dim); //
        
        compute = new JButton("Compute"); //
        reset = new JButton("Reset"); //
       
        JPanel buttonPanel = new JPanel(); //
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); //
        buttonPanel.add(compute); //
        buttonPanel.add(reset); //
        
        compute.addActionListener(e -> computeButtonClicked());
        reset.addActionListener(e -> resetButtonClicked());
        
        JPanel panel = new JPanel(); //     
        panel.setLayout(new GridBagLayout()); //
        panel.add(new JLabel("Length: "), getConstraints(0,0));
        panel.add(lengthField, getConstraints(1,0));
        panel.add(new JLabel("Width: "), getConstraints(0,1));
        panel.add(widthField, getConstraints(1,1));
        panel.add(new JLabel("Area: "), getConstraints(0,2));
        panel.add(areaField, getConstraints(1,2));
        panel.add(new JLabel("Perimiter: "), getConstraints(0,3));
        panel.add(perimeterField, getConstraints(1,3));
        
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setSize(new Dimension(250,180)); //sets initial dimension
        setVisible(true); //makes everything visable
    }

    // Helper method to return GridBagConstraints objects
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }

    private void computeButtonClicked() {
        // TODO: Implement code
        SwingValidator x = new SwingValidator();
        String errorMsg = "";
        errorMsg += x.isDouble(lengthField.getText(), "Length");
        errorMsg += x.isDouble(widthField.getText(), "Width");
        
        if (errorMsg.isEmpty()) {
            Rectangle Rec = new Rectangle();
            double l = Double.parseDouble(lengthField.getText());
            double w = Double.parseDouble(widthField.getText());
            Rec.setLength(l);
            Rec.setWidth(w);
            
            String a = Rec.getAreaNumberFormat();
            areaField.setText(a);
            
            String p = Rec.getPerimeterNumberFormat();
            perimeterField.setText(p);
        } else {
            JOptionPane.showMessageDialog(this, errorMsg, 
                    "Invalid Data", JOptionPane.ERROR_MESSAGE);
        }    
    }

    private void resetButtonClicked() {
        // TODO: Implement code
        lengthField.setText("");
        widthField.setText("");
        areaField.setText("");
        perimeterField.setText("");
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new AreaAndPerimeterFrame();
        });        
    }
}