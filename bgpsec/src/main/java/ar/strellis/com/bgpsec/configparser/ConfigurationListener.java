// Generated from ar/strellis/com/bgpsec/configparser/Configuration.g4 by ANTLR 4.7
package ar.strellis.com.bgpsec.configparser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConfigurationParser}.
 */
public interface ConfigurationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ConfigurationParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ConfigurationParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ConfigurationParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ConfigurationParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#statement_interface}.
	 * @param ctx the parse tree
	 */
	void enterStatement_interface(ConfigurationParser.Statement_interfaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#statement_interface}.
	 * @param ctx the parse tree
	 */
	void exitStatement_interface(ConfigurationParser.Statement_interfaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#interface_desc}.
	 * @param ctx the parse tree
	 */
	void enterInterface_desc(ConfigurationParser.Interface_descContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#interface_desc}.
	 * @param ctx the parse tree
	 */
	void exitInterface_desc(ConfigurationParser.Interface_descContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_interface}.
	 * @param ctx the parse tree
	 */
	void enterOption_interface(ConfigurationParser.Option_interfaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_interface}.
	 * @param ctx the parse tree
	 */
	void exitOption_interface(ConfigurationParser.Option_interfaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_interface_description}.
	 * @param ctx the parse tree
	 */
	void enterOption_interface_description(ConfigurationParser.Option_interface_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_interface_description}.
	 * @param ctx the parse tree
	 */
	void exitOption_interface_description(ConfigurationParser.Option_interface_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_interface_ip}.
	 * @param ctx the parse tree
	 */
	void enterOption_interface_ip(ConfigurationParser.Option_interface_ipContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_interface_ip}.
	 * @param ctx the parse tree
	 */
	void exitOption_interface_ip(ConfigurationParser.Option_interface_ipContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_interface_netmask}.
	 * @param ctx the parse tree
	 */
	void enterOption_interface_netmask(ConfigurationParser.Option_interface_netmaskContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_interface_netmask}.
	 * @param ctx the parse tree
	 */
	void exitOption_interface_netmask(ConfigurationParser.Option_interface_netmaskContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_interface_negotiation}.
	 * @param ctx the parse tree
	 */
	void enterOption_interface_negotiation(ConfigurationParser.Option_interface_negotiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_interface_negotiation}.
	 * @param ctx the parse tree
	 */
	void exitOption_interface_negotiation(ConfigurationParser.Option_interface_negotiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#statement_router}.
	 * @param ctx the parse tree
	 */
	void enterStatement_router(ConfigurationParser.Statement_routerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#statement_router}.
	 * @param ctx the parse tree
	 */
	void exitStatement_router(ConfigurationParser.Statement_routerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_router}.
	 * @param ctx the parse tree
	 */
	void enterOption_router(ConfigurationParser.Option_routerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_router}.
	 * @param ctx the parse tree
	 */
	void exitOption_router(ConfigurationParser.Option_routerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_router_kind}.
	 * @param ctx the parse tree
	 */
	void enterOption_router_kind(ConfigurationParser.Option_router_kindContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_router_kind}.
	 * @param ctx the parse tree
	 */
	void exitOption_router_kind(ConfigurationParser.Option_router_kindContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_router_asnumber}.
	 * @param ctx the parse tree
	 */
	void enterOption_router_asnumber(ConfigurationParser.Option_router_asnumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_router_asnumber}.
	 * @param ctx the parse tree
	 */
	void exitOption_router_asnumber(ConfigurationParser.Option_router_asnumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_router_log}.
	 * @param ctx the parse tree
	 */
	void enterOption_router_log(ConfigurationParser.Option_router_logContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_router_log}.
	 * @param ctx the parse tree
	 */
	void exitOption_router_log(ConfigurationParser.Option_router_logContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#neighbor}.
	 * @param ctx the parse tree
	 */
	void enterNeighbor(ConfigurationParser.NeighborContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#neighbor}.
	 * @param ctx the parse tree
	 */
	void exitNeighbor(ConfigurationParser.NeighborContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#neighbor_description}.
	 * @param ctx the parse tree
	 */
	void enterNeighbor_description(ConfigurationParser.Neighbor_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#neighbor_description}.
	 * @param ctx the parse tree
	 */
	void exitNeighbor_description(ConfigurationParser.Neighbor_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#neighbor_description_string}.
	 * @param ctx the parse tree
	 */
	void enterNeighbor_description_string(ConfigurationParser.Neighbor_description_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#neighbor_description_string}.
	 * @param ctx the parse tree
	 */
	void exitNeighbor_description_string(ConfigurationParser.Neighbor_description_stringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#neighbor_ip}.
	 * @param ctx the parse tree
	 */
	void enterNeighbor_ip(ConfigurationParser.Neighbor_ipContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#neighbor_ip}.
	 * @param ctx the parse tree
	 */
	void exitNeighbor_ip(ConfigurationParser.Neighbor_ipContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#neighbor_type}.
	 * @param ctx the parse tree
	 */
	void enterNeighbor_type(ConfigurationParser.Neighbor_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#neighbor_type}.
	 * @param ctx the parse tree
	 */
	void exitNeighbor_type(ConfigurationParser.Neighbor_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#remote_as}.
	 * @param ctx the parse tree
	 */
	void enterRemote_as(ConfigurationParser.Remote_asContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#remote_as}.
	 * @param ctx the parse tree
	 */
	void exitRemote_as(ConfigurationParser.Remote_asContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#statement_options}.
	 * @param ctx the parse tree
	 */
	void enterStatement_options(ConfigurationParser.Statement_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#statement_options}.
	 * @param ctx the parse tree
	 */
	void exitStatement_options(ConfigurationParser.Statement_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#options_desc}.
	 * @param ctx the parse tree
	 */
	void enterOptions_desc(ConfigurationParser.Options_descContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#options_desc}.
	 * @param ctx the parse tree
	 */
	void exitOptions_desc(ConfigurationParser.Options_descContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#option_general}.
	 * @param ctx the parse tree
	 */
	void enterOption_general(ConfigurationParser.Option_generalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#option_general}.
	 * @param ctx the parse tree
	 */
	void exitOption_general(ConfigurationParser.Option_generalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#zebra_socket_desc}.
	 * @param ctx the parse tree
	 */
	void enterZebra_socket_desc(ConfigurationParser.Zebra_socket_descContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#zebra_socket_desc}.
	 * @param ctx the parse tree
	 */
	void exitZebra_socket_desc(ConfigurationParser.Zebra_socket_descContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#full_duplex}.
	 * @param ctx the parse tree
	 */
	void enterFull_duplex(ConfigurationParser.Full_duplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#full_duplex}.
	 * @param ctx the parse tree
	 */
	void exitFull_duplex(ConfigurationParser.Full_duplexContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#half_duplex}.
	 * @param ctx the parse tree
	 */
	void enterHalf_duplex(ConfigurationParser.Half_duplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#half_duplex}.
	 * @param ctx the parse tree
	 */
	void exitHalf_duplex(ConfigurationParser.Half_duplexContext ctx);
}