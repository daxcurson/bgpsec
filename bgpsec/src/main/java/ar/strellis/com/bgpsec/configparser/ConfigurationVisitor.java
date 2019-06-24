// Generated from ar/strellis/com/bgpsec/configparser/Configuration.g4 by ANTLR 4.7
package ar.strellis.com.bgpsec.configparser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConfigurationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConfigurationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ConfigurationParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ConfigurationParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#statement_interface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_interface(ConfigurationParser.Statement_interfaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#interface_desc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterface_desc(ConfigurationParser.Interface_descContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_interface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_interface(ConfigurationParser.Option_interfaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_interface_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_interface_description(ConfigurationParser.Option_interface_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_interface_ip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_interface_ip(ConfigurationParser.Option_interface_ipContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_interface_netmask}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_interface_netmask(ConfigurationParser.Option_interface_netmaskContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_interface_negotiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_interface_negotiation(ConfigurationParser.Option_interface_negotiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#statement_router}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_router(ConfigurationParser.Statement_routerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_router}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_router(ConfigurationParser.Option_routerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_router_kind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_router_kind(ConfigurationParser.Option_router_kindContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_router_asnumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_router_asnumber(ConfigurationParser.Option_router_asnumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_router_log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_router_log(ConfigurationParser.Option_router_logContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#neighbor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeighbor(ConfigurationParser.NeighborContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#neighbor_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeighbor_description(ConfigurationParser.Neighbor_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#neighbor_description_string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeighbor_description_string(ConfigurationParser.Neighbor_description_stringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#neighbor_ip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeighbor_ip(ConfigurationParser.Neighbor_ipContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#neighbor_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeighbor_type(ConfigurationParser.Neighbor_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#remote_as}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemote_as(ConfigurationParser.Remote_asContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#statement_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_options(ConfigurationParser.Statement_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#options_desc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptions_desc(ConfigurationParser.Options_descContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#option_general}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption_general(ConfigurationParser.Option_generalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#zebra_socket_desc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZebra_socket_desc(ConfigurationParser.Zebra_socket_descContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#full_duplex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull_duplex(ConfigurationParser.Full_duplexContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConfigurationParser#half_duplex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalf_duplex(ConfigurationParser.Half_duplexContext ctx);
}