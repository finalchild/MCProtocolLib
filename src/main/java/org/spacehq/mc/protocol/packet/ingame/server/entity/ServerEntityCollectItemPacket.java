package org.spacehq.mc.protocol.packet.ingame.server.entity;

import org.spacehq.mc.protocol.util.ReflectionToString;
import org.spacehq.packetlib.io.NetInput;
import org.spacehq.packetlib.io.NetOutput;
import org.spacehq.packetlib.packet.Packet;

import java.io.IOException;

public class ServerEntityCollectItemPacket implements Packet {

    private int collectedEntityId;
    private int collectorEntityId;
    private int pickupItemCount;

    @SuppressWarnings("unused")
    private ServerEntityCollectItemPacket() {
    }

    public ServerEntityCollectItemPacket(int collectedEntityId, int collectorEntityId, int pickupItemCount) {
        this.collectedEntityId = collectedEntityId;
        this.collectorEntityId = collectorEntityId;
        this.pickupItemCount = pickupItemCount;
    }

    public int getCollectedEntityId() {
        return this.collectedEntityId;
    }

    public int getCollectorEntityId() {
        return this.collectorEntityId;
    }

    @Override
    public void read(NetInput in) throws IOException {
        this.collectedEntityId = in.readVarInt();
        this.collectorEntityId = in.readVarInt();
        this.pickupItemCount = in.readVarInt();
    }

    @Override
    public void write(NetOutput out) throws IOException {
        out.writeVarInt(this.collectedEntityId);
        out.writeVarInt(this.collectorEntityId);
        out.writeVarInt(this.pickupItemCount);
    }

    @Override
    public boolean isPriority() {
        return false;
    }

    @Override
    public String toString() {
        return ReflectionToString.toString(this);
    }
}
