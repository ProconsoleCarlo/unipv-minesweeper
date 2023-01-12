package ui;

import game.Minesweeper;
import game.MinesweeperSettings;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import utils.OnlyNumberDocument;
import utils.RestrictedContentsField;
/**
 * Il frame contenente i parametri del campo minato
 * @author Carlo
 *
 */
public class ParameterFrame {

	private MinesweeperSettings settings = MinesweeperSettings.getMinesweeperSettings();
	
	private Minesweeper minesweeperUI;
	public ParameterFrame(Minesweeper minesweeperUI) {
		super();
		this.minesweeperUI = minesweeperUI;
	}

	/**
	 * Crea il frame dei parametri
	 */
	public void createParameterFrame() {
		final JFrame frameParameters = new JFrame();
		frameParameters.setTitle("Parametri");
		frameParameters.setAlwaysOnTop(true);
		frameParameters.setLayout(new GridLayout(4, 2));
		
		final RestrictedContentsField xDimension = new RestrictedContentsField(frameParameters, new OnlyNumberDocument());
		xDimension.setFieldLabel("Dimensione orizzontale:");
		final JTextField xField = xDimension.createRestrictedIntJTextField();
		
		final RestrictedContentsField yDimension = new RestrictedContentsField(frameParameters, new OnlyNumberDocument());
		yDimension.setFieldLabel("Dimensione verticale:");
		final JTextField yField = yDimension.createRestrictedIntJTextField();
		
		final RestrictedContentsField nMine = new RestrictedContentsField(frameParameters, new OnlyNumberDocument());
		nMine.setFieldLabel("Numero mine:");
		final JTextField nMineField = nMine.createRestrictedIntJTextField();

		setSettingsInField(xField, yField, nMineField);
		
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.valueOf(xField.getText()) < 5 || Integer.valueOf(yField.getText()) < 5){
					JOptionPane.showMessageDialog (null, "Dimensione troppo piccola!\nLa dimensione minima è 5x5");
				}else {
					if (Integer.valueOf(nMineField.getText()) < 1 ||
							Integer.valueOf(nMineField.getText()) > Integer.valueOf(xField.getText())*Integer.valueOf(yField.getText())) {
						JOptionPane.showMessageDialog (null, "Numero di mine non valido!\nDeve essere maggiore 0 e minore di "
							+Integer.valueOf(xField.getText())*Integer.valueOf(yField.getText()));
					}else {
						settings.setCampWidth(Integer.valueOf(xField.getText()));
						settings.setCampHeight(Integer.valueOf(yField.getText()));
						settings.setMineNumber(Integer.valueOf(nMineField.getText()));
						try {
							setSettingsInField(xField, yField, nMineField);
							minesweeperUI.initializeGame();
							minesweeperUI.createUI();
							minesweeperUI.update();
							frameParameters.dispose();
						} catch (CloneNotSupportedException e) {
							e.printStackTrace();
						}	
					}
				}
			}	 
		});
		JButton cancelButton = new JButton("Annulla");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameParameters.dispose();
			}
		});
		frameParameters.add(okButton);
		frameParameters.add(cancelButton);
		frameParameters.setVisible(true);
	}
	private void setSettingsInField(final JTextField xField,
			final JTextField yField, final JTextField nMineField) {
		xField.setText(String.valueOf(settings.getCampWidth()));
		yField.setText(String.valueOf(settings.getCampHeight()));
		nMineField.setText(String.valueOf(settings.getMineNumber()));
	}
}
