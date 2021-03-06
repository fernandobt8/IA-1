package view;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class UserViewImpl extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private TableModel tableModel;
	private Jogo jogo;

	public UserViewImpl(Jogo jogo) {
		this.jogo = jogo;
		this.setResizable(false);
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
				final int col = UserViewImpl.this.table.columnAtPoint(e.getPoint());
				UserViewImpl.this.slotOnMouseClick(col);
			}
		});

		this.table.setShowVerticalLines(true);
		this.table.setRowHeight(75);
		this.table.setPreferredScrollableViewportSize(this.table.getPreferredSize());

		panel.add(this.table);
	}

	public void slotOnMouseClick(int col) {
		this.jogo.jogar(col);
	}

	public void updateTableModel(Tabuleiro tabuleiro) {
		this.tableModel.setTabuleiro(tabuleiro);
		this.table.repaint();
	}

	public void showWin() {
		JOptionPane.showMessageDialog(null, "Você ganhou!");
		this.jogarNovamente();
	}

	public void showLoser() {
		JOptionPane.showMessageDialog(null, "Você perdeu!");
		this.jogarNovamente();
	}

	private void jogarNovamente() {
		String[] options = new String[2];
		options[0] = "Sim";
		options[1] = "Não";
		int choice = JOptionPane.showOptionDialog(null, "Jogar novamente?", "Fim de jogo", 1, 1, null, options, null);

		if (choice == 0) {
			this.dispose();
			new GameSettings();
		} else {
			System.exit(0);
		}
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
