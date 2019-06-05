
package ch.hearc.cours_04_advanced.chat.main.tools;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;

import ch.hearc.cours_04_advanced.chat.main.Application;
import ch.hearc.cours_04_advanced.chat.main.JChat_A;
import ch.hearc.cours_04_advanced.chat.main.video.Animator;

public class JChatTemp extends JChat_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JChatTemp()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public synchronized void setText(String text)
		{
		labelText.setText(text);
		}

	@Override
	public synchronized void setRemoteImage(BufferedImage bImage)
		{
		this.bImage = bImage;
		repaint();
		}

	@Override
	public void setLocalImage(BufferedImage bLocalImage)
		{

		}

	@Override
	public void setRemotePseudo(String remotePseudo)
		{
		this.remotePseudo = remotePseudo;
		}

	@Override
	public void setLocalPseudo(String localPseudo)
		{
		this.localPseudo = localPseudo;
		}

	@Override
	public void showError(String error)
		{
		labelError.setText(error);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D)g;

		AffineTransform transform = g2D.getTransform(); //sauvegarde
		Color color = g2D.getColor(); //sauvegarde
		Font font = g2D.getFont(); //sauvegarde

		dessiner(g2D);

		g2D.setFont(font); //restore
		g2D.setColor(color); //restore
		g2D.setTransform(transform); //restore
		}

	private void dessiner(Graphics2D g2d)
		{
		g2d.drawImage(bImage, 0, 0, null);
		}

	private void geometry()
		{
		labelText = new JLabel();
		labelError = new JLabel();
		buttonText = new JButton("Send text");
		buttonImage = new JButton("Send Image");

		FlowLayout flowLayout = new FlowLayout();
		this.setLayout(flowLayout);

		this.add(labelText);
		this.add(labelError);
		this.add(buttonText);
		this.add(buttonImage);
		}

	private void control()
		{
		buttonText.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				Application.getInstance().sendText("Coucou" + compteur++);
				}

			private int compteur = 0;
			});

		buttonImage.addActionListener(e -> Animator.getInstance().start());
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private BufferedImage bImage;
	private String remotePseudo;
	private String localPseudo;

	// Tools
	private JLabel labelText;
	private JLabel labelError;
	private JButton buttonText;
	private JButton buttonImage;

	}
