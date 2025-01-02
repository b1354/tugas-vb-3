package org.test.tugas.registrasi.view.components;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextInput {
    String labelName;
    int labelWidth, labelHeight, tfWidth, tfHeight;
    
    JLabel label = new JLabel(labelName);
    JTextField textField = new JTextField();

    public TextInput(){
        this.labelName = "label";
        this.labelWidth = 100;
        this.labelHeight = 20;
        this.tfWidth = 400;
        this.tfHeight = 20;
        
        this.label = new JLabel(labelName);
        this.textField = new JTextField();
    }

    public TextInput(String labelName) {
        this.labelName = labelName;
        this.labelWidth = 100;
        this.labelHeight = 20;
        this.tfWidth = 400;
        this.tfHeight = 20;
        
        this.label = new JLabel(labelName);
        this.textField = new JTextField();
    }

    public void add(JFrame frame, int x, int y) {
        this.label.setBounds(x, y, labelWidth, labelHeight);
        this.textField.setBounds(x + 50, y, tfWidth, tfHeight);

        frame.add(this.label);
        frame.add(this.textField);
    }

    public void setWidth(int width) {
        this.tfWidth = width;
    }

    public String getTextField() {
        return textField.getText();
    }

    public void setTextField(String value) {
        textField.setText(value);
    }

    public void requestFocus() {
        textField.requestFocus();
    }
}
