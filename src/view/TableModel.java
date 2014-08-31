package view;

import javax.swing.table.AbstractTableModel;

import estrutura.tabuleiro.Token;

public class TableModel extends AbstractTableModel {
	private static final long serialVersionUID = -979825791869850910L;

	@Override
	public String getColumnName(int column) {
		return Integer.toString(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getRowCount() {
		return 6;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return Token.BLUE;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}
}
