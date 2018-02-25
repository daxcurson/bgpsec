# bgpsec

A Router written in Java that implements the BGP protocol with the BGPSec extensions, as described in RFC 8205 and others.

## What is bgpsec?

As described in [RFC 8205](https://tools.ietf.org/html/rfc8205), BGPSec is an extension to the BGP protocol that provides security for the path of Autonomous Systems (ASes) through which a BGP UPDATE message passes.  BGPsec is implemented via an optional non-transitive BGP path attribute that carries digital signatures produced by each AS that propagates the  UPDATE message.  The digital signatures provide confidence that every AS on the path of ASes listed in the UPDATE message has explicitly authorized the advertisement of the route.

BGPSec aims to address weaknesses in the current BGP protocol as implemented in [RFC 4271](https://tools.ietf.org/html/rfc4271) and subsequent RFCs. A few of these can be described as follows:

- The lack of a way to tell if the route advertised by the BGP peer actually owns the route being advertised. This has started to be addressed with RFCs 6480-93.
- The lack of a way to confirm that the actual path to the AS that reports the route is indeed correct.
- The ability to easily spoof an AS and trick BGP peers into believing that they are talking to the proper AS for a route.

The consequence of this lack of validation of BGP messages results in frequent events of route hijacking that disrupt the operation of BGP and Internet in general. Although the actual use of BGP is restricted to a few organizations, and that the setup and operation of BGP-capable routers is made with the intent to provide a stable service that would work in the best interest of the Internet service providers and their customers, errors will and do happen, and often the best intentions can be twisted, systems can be hacked and infrastructure can be compromised, resulting in disruptions that can affect the Internet as a whole.

## Project objectives

- Provide a routing software written in Java that would implement the BGP protocol with the BGPSec extensions, with the following features:
  - Multi-platform support (but only Linux in the early implementation steps).
  - RFC-8205 compliant.
  - Easily configurable with Cisco-compatible configuration instructions.
- Serve as a thesis in information security, that would explore the weaknesses of BGP as implemented in the currently-existing RFCs previous to the approval of RFC 8205, and analyze how the security of the protocol is improved with the newer RFCs.
- Become an opportunity to learn Java, low-level implementation of routing changes, operation of an Internet-facing networking service, and have fun ;-).
- Provide yet another example of a networking service using [Apache MINA](https://mina.apache.org/), which is a very interesting networking library, that is very powerful, yet not very well understood.

## Current status

The software is in its early implementation stages. The basic processing of BGP messages has already been implemented, work is being done to complete a working implementation of a BGP router that would be able to interpret and accept BGP messages in a GNS3 simulator. 

## How to contribute

You can:
- Check the available tickets.
- Develop wiki articles.
- Use the software and contribute with pull requests.

If you want to be actively involved in the development of bgpsec, please send me a message using [Twitter](https://twitter.com/IngAgustinV).