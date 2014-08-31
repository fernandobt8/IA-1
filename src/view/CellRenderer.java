package view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import estrutura.tabuleiro.Token;

public class CellRenderer extends DefaultTableCellRenderer {
	JLabel lbl = new JLabel();

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		this.lbl.setIcon(new ImageIcon(this.getClass().getResource(((Token) value).getImage())));
		return this.lbl;
	}
}