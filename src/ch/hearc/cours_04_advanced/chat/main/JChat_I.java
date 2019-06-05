
package ch.hearc.cours_04_advanced.chat.main;

import java.awt.image.BufferedImage;

public interface JChat_I
	{

	public void setText(String text);

	public void setRemoteImage(BufferedImage bRemoteImage);

	public void setLocalImage(BufferedImage bLocalImage);

	public void setRemotePseudo(String remotePseudo);

	public void setLocalPseudo(String localPseudo);

	public void showError(String error);

	}
