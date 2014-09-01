package view;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class UserViewImpl extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private TableModel tableModel;
	private Jogo jogo;
	private JTextField textField;

	public UserViewImpl(Jogo jogo) {
		this.jogo = jogo;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 600);

		JPanel panel = new JPanel();
		this.getContentPane().add(panel);

		this.tableModel = new TableModel();
		this.table = new JTable(this.tableModel);
		this.table.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
		this.table.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
		this.table.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer());
		this.table.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer());
		this.table.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
		this.table.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer());
		this.table.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer());
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = UserViewImpl.this.table.rowAtPoint(e.getPoint());
				int col = UserViewImpl.this.table.columnAtPoint(e.getPoint());
				UserViewImpl.this.slotOnMouseClick(row, col);
			}
		});

		this.table.setShowVerticalLines(true);
		this.table.setRowHeight(75);
		this.table.setPreferredScrollableViewportSize(this.table.getPreferredSize());

		panel.add(this.table);
		JButton reset = new JButton("Reset");
		panel.add(reset);
		JButton menos = new JButton("menos");
		panel.add(menos);

		this.textField = new JTextField();
		panel.add(this.textField);
		this.textField.setColumns(10);
		JButton mais = new JButton("mais");
		panel.add(mais);
	}

	public void slotOnMouseClick(int row, int col) {
		this.jogo.jogar(row, col);
	}

	public void updateTableModel(Tabuleiro tabuleiro) {
		this.tableModel.setTabuleiro(tabuleiro);
	}

	public void showWin() {
		JOptionPane.showMessageDialog(null, "Você ganhou!");
	}

	public void showLoser() {
		JOptionPane.showMessageDialog(null, "Você perdeu!");
	}

	public class CellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = -2316443649170917750L;

		JLabel lbl = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			ImageIcon icon = new ImageIcon(this.getClass().getResource(((Token) value).getImage()));
			this.lbl.setIcon(icon);
			return this.lbl;
		}
	}
}
