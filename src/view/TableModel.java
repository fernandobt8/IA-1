package view;

import javax.swing.table.AbstractTableModel;

import estrutura.tabuleiro.Tabuleiro;

public class TableModel extends AbstractTableModel {
	private static final long serialVersionUID = -979825791869850910L;
	private Tabuleiro tabuleiro;

	public TableModel() {
		this.tabuleiro = new Tabuleiro();
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				this.fireTableCellUpdated(i, j);
			}
		}
	}

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
		return this.tabuleiro.getCasa(rowIndex, columnIndex).getTipoCasa();
	}
}
