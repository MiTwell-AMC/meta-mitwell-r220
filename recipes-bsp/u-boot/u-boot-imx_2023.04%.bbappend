FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"


SRC_URI +=   " \
             file://0001-Modify-defconfig-m330e-r220.patch \
             file://imx93-mitwell-r220-mickledore-uboot.dts \
             file://ddr4_timing_H9HCNNNBKUMLHR_3200MHz.c \
             "

do_copy_source () {
	# Copy device tree
	cp ${WORKDIR}/imx93-mitwell-r220-mickledore-uboot.dts ${S}/arch/arm/dts/imx93-11x11-evk.dts
	# DDR4 timing replacement
	cp ${WORKDIR}/ddr4_timing_H9HCNNNBKUMLHR_3200MHz.c ${S}/board/freescale/imx93_evk/lpddr4x_timing.c
}

addtask copy_source before do_patch after do_unpack
