package SourceClasses;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EFSPANEL extends JPanel {
	// Manuel Corral
	// this class takes in whatever the user types when they click submit

	final int FIELD_WIDTH = 10;
	StopLightDrawing light = new StopLightDrawing();
	JTextField rateField = new JTextField(FIELD_WIDTH);
	JLabel resultLabel = new JLabel("");
	JLabel promptLabel = new JLabel("Please Enter A WindSpeed: ");
	JButton newButton = new JButton("Submit");
	public String switchLight = "";

	Color ef0 = Color.gray;
	Color ef1 = Color.gray;
	Color ef2 = Color.gray;
	Color ef3 = Color.gray;
	Color ef4 = Color.gray;
	Color ef5 = Color.gray;

	public EFSPANEL() {

		light.setPreferredSize(new Dimension(160, 260));

		buttonListener l = new buttonListener();
		newButton.addActionListener(l);

		add(light);
		add(promptLabel);
		add(newButton);
		add(rateField);
		add(resultLabel);
		

	}

	class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			try {
				double rate = Double.parseDouble(rateField.getText());

				if (rate >= 65) {
					if (rate >= 65 && rate <= 85) {
						resultLabel.setText("EF RATING: 0");
						switchLight = "ef0";
					} else if (rate >= 86 && rate <= 110) {
						resultLabel.setText("EF RATING: 1");
						switchLight = "ef1";
					} else if (rate >= 111 && rate <= 135) {
						resultLabel.setText("EF RATING: 2");
						switchLight = "ef2";
					} else if (rate >= 136 && rate <= 165) {
						resultLabel.setText("EF RATING: 3");
						switchLight = "ef3";
					} else if (rate >= 166 && rate <= 200) {
						resultLabel.setText("EF RATING: 4");
						switchLight = "ef4";
					} else if (rate >= 201) {
						resultLabel.setText("EF RATING: 5");
						switchLight = "ef5";
					}
				} else {
					throw new NumberFormatException();
				}

			} catch (NumberFormatException e) {
				resultLabel.setText("Please enter a positive integer equal to or greater than 65");
				switchLight = "";
			}
			light.changeColor();
		}

	}

	public class StopLightDrawing extends JComponent {

		Color ef0 = Color.gray;
		Color ef1 = Color.gray;
		Color ef2 = Color.gray;
		Color ef3 = Color.gray;
		Color ef4 = Color.gray;
		Color ef5 = Color.gray;

		public void paintComponent(Graphics i) {

			i.setColor(ef5);
			i.fillRect(55, 35, 35, 35);

			i.setColor(ef4);
			i.fillRect(55, 70, 35, 35);

			i.setColor(ef3);
			i.fillRect(55, 105, 35, 35);

			i.setColor(ef2);
			i.fillRect(55, 140, 35, 35);

			i.setColor(ef1);
			i.fillRect(55, 175, 35, 35);

			i.setColor(ef0);
			i.fillRect(55, 210, 35, 35);

		}

		public void changeColor() {

			if (switchLight.equals("ef0")) {
				ef0 = Color.yellow;
				ef1 = Color.gray;
				ef2 = Color.gray;
				ef3 = Color.gray;
				ef4 = Color.gray;
				ef5 = Color.gray;

			} else if (switchLight.equals("ef1")) {
				ef0 = Color.yellow;
				ef1 = Color.yellow;
				ef2 = Color.gray;
				ef3 = Color.gray;
				ef4 = Color.gray;
				ef5 = Color.gray;

			} else if (switchLight.equals("ef2")) {
				ef0 = Color.yellow;
				ef1 = Color.yellow;
				ef2 = Color.orange;
				ef3 = Color.gray;
				ef4 = Color.gray;
				ef5 = Color.gray;

			} else if (switchLight.equals("ef3")) {
				ef0 = Color.yellow;
				ef1 = Color.yellow;
				ef2 = Color.orange;
				ef3 = Color.orange;
				ef4 = Color.gray;
				ef5 = Color.gray;
			} else if (switchLight.equals("ef4")) {
				ef0 = Color.yellow;
				ef1 = Color.yellow;
				ef2 = Color.orange;
				ef3 = Color.orange;
				ef4 = Color.red;
				ef5 = Color.gray;
			} else if (switchLight.equals("ef5")) {
				ef0 = Color.yellow;
				ef1 = Color.yellow;
				ef2 = Color.orange;
				ef3 = Color.orange;
				ef4 = Color.red;
				ef5 = Color.red;
			} else {
				ef0 = Color.gray;
				ef1 = Color.gray;
				ef2 = Color.gray;
				ef3 = Color.gray;
				ef4 = Color.gray;
				ef5 = Color.gray;

			}
			repaint();
		}

	}
}
