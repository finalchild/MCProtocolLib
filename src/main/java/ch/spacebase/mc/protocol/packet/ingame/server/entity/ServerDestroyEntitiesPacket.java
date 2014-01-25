package ch.spacebase.mc.protocol.packet.ingame.server.entity;

import java.io.IOException;

import ch.spacebase.packetlib.io.NetInput;
import ch.spacebase.packetlib.io.NetOutput;
import ch.spacebase.packetlib.packet.Packet;

public class ServerDestroyEntitiesPacket implements Packet {
	
	private int entityIds[];
	
	@SuppressWarnings("unused")
	private ServerDestroyEntitiesPacket() {
	}
	
	public ServerDestroyEntitiesPacket(int... entityIds) {
		this.entityIds = entityIds;
	}
	
	public int[] getEntityIds() {
		return this.entityIds;
	}

	@Override
	public void read(NetInput in) throws IOException {
		this.entityIds = new int[in.readVarInt()];
		for(int index = 0; index < this.entityIds.length; index++) {
			this.entityIds[index] = in.readVarInt();
		}
	}

	@Override
	public void write(NetOutput out) throws IOException {
		out.writeVarInt(this.entityIds.length);
		for(int entityId : this.entityIds) {
			out.writeVarInt(entityId);
		}
	}
	
	@Override
	public boolean isPriority() {
		return false;
	}

}
