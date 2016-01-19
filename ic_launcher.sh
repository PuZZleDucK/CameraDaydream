#!/bin/bash

convert ic_launcher.png -resize 72x72   app/src/main/res/mipmap-hdpi/ic_launcher.png
convert ic_launcher.png -resize 48x48   app/src/main/res/mipmap-mdpi/ic_launcher.png
convert ic_launcher.png -resize 96x96   app/src/main/res/mipmap-xhdpi/ic_launcher.png
convert ic_launcher.png -resize 144x144 app/src/main/res/mipmap-xxhdpi/ic_launcher.png
convert ic_launcher.png -resize 192x192 app/src/main/res/mipmap-xxxhdpi/ic_launcher.png

