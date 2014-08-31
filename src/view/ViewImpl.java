package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import estrutura.tabuleiro.Token;

public class ViewImpl extends JFrame {
	private JTable table;
	private TableModel tableModel;

	public ViewImpl() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 600);

		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);

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
				int row = ViewImpl.this.table.rowAtPoint(e.getPoint());
				int col = ViewImpl.this.table.columnAtPoint(e.getPoint());
				System.out.println(row + " - " + col);
			}
		});
		this.table.setShowVerticalLines(true);
		this.table.setRowHeight(75);
		this.table.setPreferredScrollableViewportSize(this.table.getPreferredSize());

		panel.add(this.table);
	}

	public class CellRenderer extends DefaultTableCellRenderer {
		JLabel lbl = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource(((Token) value).getImage()));
			this.lbl.setIcon(icon);
			return this.lbl;
		}
	}
}
