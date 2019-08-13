package Testes;

import br.com.sss.Control.ProtocoloController;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author DIEGO
 */
public class TabelaTextAreaRenderer extends JTextArea implements TableCellRenderer{
    
    // This method is called each time a cell in a column
    // using this renderer needs to be rendered.
	
	public  TabelaTextAreaRenderer(){
		setLineWrap(true);
		setWrapStyleWord(true);
		
	}
	
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
        // 'value' is value contained in the cell located at
        // (rowIndex, vColIndex)

        if (isSelected) {
            // cell (and perhaps other cells) are selected
        }

        if (hasFocus) {
            // this cell is the anchor and the table has the focus
        }
        // Configure the component with the specified value
        setText(value.toString());

        // Set tool tip if desired
        setToolTipText((String)value);

        // Since the renderer is a component, return itself
        return this;
    }
    
}
