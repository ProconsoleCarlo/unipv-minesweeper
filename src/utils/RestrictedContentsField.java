package utils;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;
/**
 * Una generica JTextField con delle restizioni sui valori che possono essere inseriti al suo interno
 * @author Carlo
 *
 */
public class RestrictedContentsField{

	private JFrame frame;
	private JLabel fieldLabel = new JLabel();
	private PlainDocument plainDocument;
	/**
	 * @param frame Il frame su cui posizionare la JTextField
	 * @param plainDocument Il "documento" delle restrizioni da imporre alla JTextField
	 */
	public RestrictedContentsField(JFrame frame, PlainDocument plainDocument) {
		super();
		this.frame = frame;
		this.plainDocument = plainDocument;
	}
	/**
	 * La stringa che descrive la JTextField
	 * @param fieldLabel
	 */
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel.setText(fieldLabel);
	}
	/**
	 * Crea una JTextField con le restrizioni sui valori di inserimento passati dal PlainDocument
	 * @return La JTextField
	 */
	public JTextField createRestrictedIntJTextField(){
		final JTextField field = new JTextField();
		field.setDocument(plainDocument);
		frame.add(fieldLabel);
		frame.add(field);
		frame.pack();
		return field;
	}
}