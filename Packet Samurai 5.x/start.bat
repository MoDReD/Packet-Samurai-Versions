@echo off
start javaw -Xms2048m -Xmx2048m -cp ./libs/*;packetsamurai.jar com.aionemu.packetsamurai.PacketSamurai
exit