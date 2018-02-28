@echo off
set PATH="C:\SDK\jdk1.6.0_24\bin";%PATH%
java -cp ./libs/*;open-aion-packetsamurai.jar org.openaion.packetsamurai.PacketSamurai
exit