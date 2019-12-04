package br.ufc.clinic.view.telasIniciais;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.ufc.clinic.controller.AdministradorController;
import br.ufc.clinic.controller.AtendenteController;
import br.ufc.clinic.controller.MedicoController;
import br.ufc.clinic.util.ValidaUtil;
import br.ufc.clinic.view.adm.TelaMenuAdm;
import br.ufc.clinic.view.atendente.TelaMenuAtendente;
import br.ufc.clinic.view.medico.TelaMenuMedico;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JLabel;

public class TelaLogin extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	public TelaLogin() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		buttonEntrar = new javax.swing.JButton();
		bottonCadastro = new javax.swing.JButton();
		txtLogin = new javax.swing.JTextField();
		// ImageIcon iconFundo = new ImageIcon(getClass().getResource("logoppp.png"));
		// jLabel4 = new javax.swing.JLabel(iconFundo);
		txtSenha = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Acesso");
		setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setToolTipText("Acesso");

		txtLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("LOGIN"));

		txtSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtSenha.setBorder(javax.swing.BorderFactory.createTitledBorder("SENHA"));

		buttonEntrar.setBackground(new java.awt.Color(255, 255, 255));
		buttonEntrar.setFont(new java.awt.Font("Code Light", 0, 11)); // NOI18N
		buttonEntrar.setText("Entrar");
		buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonEntrarActionPerformed(evt);
			}
		});

		bottonCadastro.setBackground(new java.awt.Color(255, 255, 255));
		bottonCadastro.setFont(new java.awt.Font("Code Light", 0, 11)); // NOI18N
		bottonCadastro.setText("Cadastre-se");
		bottonCadastro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TelaCriarConta telaCriarConta = new TelaCriarConta();
				telaCriarConta.setVisible(true);
				dispose();
			}
		});
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/ufc/clinic/imagens/logoLogin.jpg")));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addComponent(jLabel4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGap(134))
				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					.addGap(156)
					.addComponent(bottonCadastro, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(buttonEntrar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtSenha, Alignment.LEADING)
						.addComponent(txtLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
					.addGap(103))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
					.addGap(28)
					.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bottonCadastro, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonEntrar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
		);
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);
	}

	public void restaurar() {
		txtLogin.setText("");
		txtSenha.setText("");
	}

	private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {
		if (txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos vazios!");
		} else {
			if (ValidaUtil.validaEmail(txtLogin.getText()) == 1) {
				if (AdministradorController.login(txtLogin.getText(), txtSenha.getText()) == true) {
					TelaMenuAdm telaMenuAdm = new TelaMenuAdm();

					telaMenuAdm.setVisible(true);
					dispose();
				}

			} else if (ValidaUtil.validaEmail(txtLogin.getText()) == 2) {
				if (AtendenteController.login(txtLogin.getText(), txtSenha.getText()) == true) {
					TelaMenuAtendente telaMenuAtendente = new TelaMenuAtendente();

					telaMenuAtendente.setVisible(true);
					dispose();
				} else {
					txtSenha.setText("");

					JOptionPane.showMessageDialog(null, "Senha incorreta!");
				}

			} else if (ValidaUtil.validaEmail(txtLogin.getText()) == 3) {
				if (MedicoController.login(txtLogin.getText(), txtSenha.getText()) == true) {
					TelaMenuMedico telaMenuMedico = new TelaMenuMedico();

					telaMenuMedico.setVisible(true);
					dispose();
				} else {
					txtSenha.setText("");

					JOptionPane.showMessageDialog(null, "Senha incorreta!");
				}

			} else if (ValidaUtil.validaEmail(txtLogin.getText()) == 4) {
				// chama a tela menu cliente;
			} else if (ValidaUtil.validaEmail(txtLogin.getText()) == 0) {
				txtLogin.setText("");
				JOptionPane.showMessageDialog(null, "Email incorreto!");
			} else {
				restaurar();

				JOptionPane.showMessageDialog(null,
						"Ocorreu um erro inesperado ao realizar login.\nPor favor, tente novamente.");
			}
		}
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaLogin().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buttonEntrar;
	private javax.swing.JButton bottonCadastro;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField txtLogin;
	private javax.swing.JPasswordField txtSenha;
	private JLabel lblNewLabel;

	// End of variables declaration//GEN-END:variables
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
