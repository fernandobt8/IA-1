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
	private JRadioButton humanoRadio;
	private JRadioButton computadorRadio;

	public GameSettings() {
		this.initializeUI();
		this.settingsFrame.setLocationRelativeTo(null);
		this.settingsFrame.setVisible(true);
	}

	private void initializeUI() {
		this.settingsFrame = new JFrame("Connect4");
		this.settingsFrame.setBounds(new Rectangle(0, 0, 345, 350));
		this.settingsFrame.setResizable(false);
		this.settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.settingsFrame.getContentPane().setLayout(null);

		JLabel titleLabel = new JLabel("Seja bem-vindo ao invencível Connect4...");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLabel.setBounds(10, 11, 320, 20);
		this.settingsFrame.getContentPane().add(titleLabel);

		JLabel difficultyLabel = new JLabel("Escolha o nível de dificuldade:");
		difficultyLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		difficultyLabel.setBounds(82, 42, 210, 15);
		this.settingsFrame.getContentPane().add(difficultyLabel);

		this.dif1Radio = new JRadioButton("\tI am a wimp (1)");
		this.dif1Radio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.dif1Radio.setBounds(109, 64, 120, 23);
		this.settingsFrame.getContentPane().add(this.dif1Radio);

		this.dif2Radio = new JRadioButton("Hey, not too rough (2)");
		this.dif2Radio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.dif2Radio.setBounds(109, 90, 155, 23);
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
				int primeiroJogador = GameSettings.this.getPrimeiroJogador();

				if (dificuldade == 0) {
					JOptionPane.showMessageDialog(null, "Não seja covarde. Escolha uma dificuldade ¬¬");
				} else {
					GameSettings.this.settingsFrame.dispose();
					new Jogo(dificuldade, primeiroJogador);
				}
			}
		});
		iniciarButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		iniciarButton.setBounds(10, 253, 315, 25);
		this.settingsFrame.getContentPane().add(iniciarButton);

		JButton fugirButton = new JButton("Fugir :(");
		fugirButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fugirButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fugirButton.setBounds(10, 287, 315, 25);
		this.settingsFrame.getContentPane().add(fugirButton);

		ButtonGroup groupDificuldade = new ButtonGroup();
		groupDificuldade.add(this.dif1Radio);
		groupDificuldade.add(this.dif2Radio);
		groupDificuldade.add(this.dif4Radio);
		groupDificuldade.add(this.dif7Radio);

		JLabel lblQuemJogaPrimeiro = new JLabel("Quem joga primeiro?");
		lblQuemJogaPrimeiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuemJogaPrimeiro.setBounds(116, 189, 130, 15);
		this.settingsFrame.getContentPane().add(lblQuemJogaPrimeiro);

		this.humanoRadio = new JRadioButton("Humano");
		this.humanoRadio.setSelected(true);
		this.humanoRadio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.humanoRadio.setBounds(82, 211, 75, 23);
		this.settingsFrame.getContentPane().add(this.humanoRadio);

		this.computadorRadio = new JRadioButton("Computador");
		this.computadorRadio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.computadorRadio.setBounds(159, 211, 95, 23);
		this.settingsFrame.getContentPane().add(this.computadorRadio);

		ButtonGroup groupPrimeiroJogador = new ButtonGroup();
		groupPrimeiroJogador.add(this.humanoRadio);
		groupPrimeiroJogador.add(this.computadorRadio);
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

	protected int getPrimeiroJogador() {
		if (this.humanoRadio.isSelected()) {
			return 0;
		}
		return 1;
	}
}
