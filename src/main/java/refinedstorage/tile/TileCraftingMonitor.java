package refinedstorage.tile;

import net.minecraft.item.ItemStack;
import refinedstorage.RefinedStorage;

import java.util.ArrayList;
import java.util.List;

// @TODO: Make this work!
public class TileCraftingMonitor extends TileNode {
    private List<ClientSideCraftingTask> tasks = new ArrayList<ClientSideCraftingTask>();

    @Override
    public int getEnergyUsage() {
        return RefinedStorage.INSTANCE.craftingMonitorUsage;
    }

    @Override
    public void updateNode() {
    }

    /*@Override
    public void writeContainerData(ByteBuf buf) {
        super.writeContainerData(buf);

        if (connected) {
            buf.writeInt(network.getCraftingTasks().size());

            for (ICraftingTask task : network.getCraftingTasks()) {
                ByteBufUtils.writeUTF8String(buf, task.getInfo());

                buf.writeInt(task.getPattern().getOutputs().length);

                for (ItemStack output : task.getPattern().getOutputs()) {
                    ByteBufUtils.writeItemStack(buf, output);
                }
            }
        } else {
            buf.writeInt(0);
        }
    }

    @Override
    public void readContainerData(ByteBuf buf) {
        super.readContainerData(buf);

        int size = buf.readInt();

        List<ClientSideCraftingTask> newTasks = new ArrayList<ClientSideCraftingTask>();

        for (int i = 0; i < size; ++i) {
            String info = ByteBufUtils.readUTF8String(buf);

            int outputs = buf.readInt();

            for (int j = 0; j < outputs; ++j) {
                newTasks.add(new ClientSideCraftingTask(ByteBufUtils.readItemStack(buf), i, info));
            }
        }

        Collections.reverse(newTasks);

        tasks = newTasks;
    }*/

    public List<ClientSideCraftingTask> getTasks() {
        return tasks;
    }

    public class ClientSideCraftingTask {
        public ItemStack output;
        public int id;
        public String info;

        public ClientSideCraftingTask(ItemStack output, int id, String info) {
            this.output = output;
            this.id = id;
            this.info = info;
        }
    }
}
