DESCRIPTION = "MiTwell Image to validate i.MX machines. \
This image contains everything used to test i.MX machines including GUI, \
demos and lots of applications. This creates a very large image, \
for product development and evaluation purposes only."
LICENSE = "MIT"

inherit core-image

IMAGE_FSTYPES:append = " wic"
IMAGE_FSTYPES:remove = " tar tar.bz2 ext4"


## Select Image Features
IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    tools-sdk \
    package-management \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-openssh \
    tools-testapps \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"

V2X_PKGS = ""
V2X_PKGS:mx8dxl-nxp-bsp = "packagegroup-imx-v2x"

DOCKER ?= ""
DOCKER:mx8-nxp-bsp = "docker"

G2D_SAMPLES              = ""
G2D_SAMPLES:imxgpu2d     = "imx-g2d-samples"
G2D_SAMPLES:mx93-nxp-bsp = "imx-g2d-samples"

IMAGE_INSTALL += " \
    libgpiod \
    ffmpeg \
    hdparm \ 
    mdio-tools "

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    firmwared \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    ${V2X_PKGS} \
    ${DOCKER} \
    ${G2D_SAMPLES} \
"
