package view;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class GameSettings {

	JFrame settingsFrame;
	private JRadioButton dif1Radio;
	private JRadioButton dif2Radio;
	private JRadioButton dif4Radio;
	private JRadioButton dif7Radio;

	public GameSettings() {
		this.initializeUI();
		this.settingsFrame.setLocationRelativeTo(null);
		this.settingsFrame.setVisible(true);
	}

	private void initializeUI() {
		this.settingsFrame = new JFrame("Connect4");
		this.settingsFrame.setBounds(new Rectangle(0, 0, 340, 290));
		this.settingsFrame.setResizable(false);
		this.settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.settingsFrame.getContentPane().setLayout(null);

		JLabel titleLabel = new JLabel("Seja bem-vindo ao invencível Connect4...");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLabel.setBounds(10, 11, 293, 20);
		this.settingsFrame.getContentPane().add(titleLabel);

		JLabel difficultyLabel = new JLabel("Escolha o nível de dificuldade:");
		difficultyLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		difficultyLabel.setBounds(82, 42, 162, 15);
		this.settingsFrame.getContentPane().add(difficultyLabel);

		this.dif1Radio = new JRadioButton("\tI am a wimp (1)");
		this.dif1Radio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.dif1Radio.setBounds(109, 64, 109, 23);
		this.settingsFrame.getContentPane().add(this.dif1Radio);

		this.dif2Radio = new JRadioButton("Hey, not too rough (2)");
		this.dif2Radio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.dif2Radio.setBounds(109, 90, 135, 23);
		this.settingsFrame.getContentPane().add(this.dif2Radio);

		this.dif4Radio = new JRadioButton("Hurt me plently (4)");
		this.dif4Radio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.dif4Radio.setBounds(109, 116, 135, 23);
		this.settingsFrame.getContentPane().add(this.dif4Radio);

		this.dif7Radio = new JRadioButton("Ultra-violence (7)");
		this.dif7Radio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.dif7Radio.setBounds(109, 142, 135, 23);
		this.settingsFrame.getContentPane().add(this.dif7Radio);

		JButton iniciarButton = new JButton("Iniciar!");
		iniciarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dificuldade = GameSettings.this.getDificuldade();

				if (dificuldade == 0) {
					JOptionPane.showMessageDialog(null, "Não seja covarde. Escolha uma dificuldade ¬¬");
				} else {
					GameSettings.this.settingsFrame.dispose();
					new Jogo(dificuldade);
				}
			}
		});
		iniciarButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		iniciarButton.setBounds(10, 190, 315, 25);
		this.settingsFrame.getContentPane().add(iniciarButton);

		JButton fugirButton = new JButton("Fugir :(");
		fugirButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fugirButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fugirButton.setBounds(10, 224, 315, 25);
		this.settingsFrame.getContentPane().add(fugirButton);

		ButtonGroup group = new ButtonGroup();
		group.add(this.dif1Radio);
		group.add(this.dif2Radio);
		group.add(this.dif4Radio);
		group.add(this.dif7Radio);
	}

	protected int getDificuldade() {
		if (this.dif1Radio.isSelected()) {
			return 1;
		}
		if (this.dif2Radio.isSelected()) {
			return 2;
		}
		if (this.dif4Radio.isSelected()) {
			return 4;
		}
		if (this.dif7Radio.isSelected()) {
			return 7;
		}
		return 0;
	}
}
