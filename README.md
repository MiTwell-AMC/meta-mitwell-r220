# meta-mitwell-r220

This chapter describes how to build an Yocto BSP for a MOSM-M330E(OSM) i.MX93 module(carrier) by using a Yocto Project build environment. 
It describes the i.MX release layer and R220-specific usage. The Yocto Project is an open-source collaboration focused on embedded Linux® OS development.

This README file contains information on the contents of the meta-mitwell-r220-hardknott layer.

Please see the corresponding sections below for details.

BSP Version
===========

imx-6.1.36-2.0.0 with Yocto Mickledore



Quick Start
===========

1. $ source setup-environment build/
2. Add this layer to bblayers.conf and the dependencies above
3. Set MACHINE in local.conf to one of the supported boards
4. $ bitbake mitwell-image
5. dd to a SD card the generated wic file 
6. Boot Yocto through SD card
7. Boot the MiTwell OSM-IMX8MP



Table of Contents
=================

  I. Adding the MiTwell layer to your build
 II. Build the Layer
III. License


I. Adding the MiTwell layer to your build
=========================================

Assuming this layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the MiTwell layer to bblayers.conf, along with any
other layers needed. e.g.:

  BBLAYERS ?= " \
    /path/to/meta \
    /path/to/meta-poky \
    /path/to/meta-yocto-bsp \
    /path/to/meta-mitwell-r220 \

or you can run 'bitbake-layers add-layer meta-mitwell-r220' command.


II. Build the Layer
===================

   Run 
   $ bitbake mitwell-bsp-layer

