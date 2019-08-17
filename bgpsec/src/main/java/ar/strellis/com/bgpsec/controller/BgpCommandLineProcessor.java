package ar.strellis.com.bgpsec.controller;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * 
 * Provides the values of configuration options, to override defaults, if any.
 * @author avillafa
 *
 */
public class BgpCommandLineProcessor 
{
	private static BgpCommandLineProcessor me;
	private Options options;
	private CommandLine cmdline;
	
	public static BgpCommandLineProcessor getInstance()
	{
		if(me==null)
			me=new BgpCommandLineProcessor();
		return me;
	}
	private BgpCommandLineProcessor()
	{
		options=new Options();
		Option help=new Option("help","Print this help message");
		options.addOption(help);
		Option configFile=Option.builder("f")
				.desc("Override the default configuration with this file")
				.hasArg()
				.argName("FILE")
				.build();
		options.addOption(configFile);
	}
	public void parseCommandLineOptions(String[] args) throws ParseException
	{
		CommandLineParser parser=new DefaultParser();
		CommandLine cmd=parser.parse(options, args);
		this.cmdline=cmd;
	}
	/**
	 * Applies the command-line options to override the defaults in the configuration.
	 * @param config
	 * @return
	 * @throws ParseException 
	 */
	public String applyCommandLineOptions(String[] args) throws ParseException
	{
		if(cmdline.hasOption("f"))
			return cmdline.getOptionValue("f");
		else
			throw new ParseException("Parameter not found");
	}
}
