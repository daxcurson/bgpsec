package ar.strellis.com.bgpsec.configparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ar.strellis.com.bgpsec.model.MyConfiguration;

public class RouterConfigurationReader
{
	private MyConfiguration configuration;
	private String configurationFilename;
	public RouterConfigurationReader(String configurationFilename) 
	{
		this.configurationFilename=configurationFilename;
		configuration=new MyConfiguration();
	}
	public MyConfiguration getConfiguration() throws FileNotFoundException,IOException
	{
		// I'll create the parser that I'll use to consume the configuration.
		File f=new File(this.configurationFilename);
		InputStream inputStream=new FileInputStream(f);
		CharStream stream=CharStreams.fromStream(inputStream);
		ConfigurationLexer lexer=new ConfigurationLexer(stream);
		CommonTokenStream tokens=new CommonTokenStream(lexer);
		ConfigurationParser parser=new ConfigurationParser(tokens);
		return configuration;
	}
}
