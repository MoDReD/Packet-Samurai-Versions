package com.aionemu.packetsamurai.parser.valuereader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.aionemu.packetsamurai.parser.datatree.ValuePart;

public class UrlOpenReader implements Reader 
{
	String _urlFormat;

	@Override
	public boolean loadReaderFromXML(Node n) 
	{
		NamedNodeMap attrs = n.getAttributes();
		Node attr = attrs.getNamedItem("url");
		if (attr == null)
			return false;
		_urlFormat = attr.getNodeValue();
		return true;
	}

	@Override
	public boolean saveReaderToXML(Element element, Document doc) 
	{
		element.setAttribute("url", _urlFormat);
		return true;
	}

	@Override
	public JComponent readToComponent(ValuePart part) 
	{
		long number = 0;
		String token = this.read(part);
		try
		{
			number = Long.parseLong(token);
			if (number == 0)
				return new JLabel(token);
		}
		catch (NumberFormatException e)
		{
		}
		
		if (token.isEmpty())
			return new JLabel("");
		
		String url = String.format(_urlFormat, this.read(part));
		JButton view = new JButton();
		try {
			URL u = new URL(url);
			view.setText(u.getAuthority());
			view.addActionListener(new ButtonActionListener(u.toString()));
			view.setActionCommand("clicked");
		} catch (MalformedURLException e) {
			view.setText("Open");
		}
		return view;
	}

	@Override
	public String read(ValuePart part) 
	{
		return part.getValueAsString();
	}

	public void openURL(String url) 
	{
		String osName = System.getProperty("os.name");
		try {
			if (osName.startsWith("Windows"))
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
			else {
				String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
				String browser = null;
				for (int count = 0; count < browsers.length && browser == null; count++)
					if (Runtime.getRuntime().exec(new String[] {"which", browsers[count]}).waitFor() == 0)
						browser = browsers[count];
				Runtime.getRuntime().exec(new String[] {browser, url});
			}
		}
		catch (Exception e) 
		{
		}
	}

	class ButtonActionListener implements ActionListener
	{
		private String _url;

		public ButtonActionListener(String url)
		{
			_url = url;
		}

		public void actionPerformed(ActionEvent e)
		{
			openURL(_url);
		}
	}	

}
