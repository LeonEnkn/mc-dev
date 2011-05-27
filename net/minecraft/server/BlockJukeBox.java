package net.minecraft.server;

public class BlockJukeBox extends Block {

    protected BlockJukeBox(int i, int j) {
        super(i, j, Material.WOOD);
    }

    public int a(int i) {
        return this.textureId + (i == 1 ? 1 : 0);
    }

    public boolean interact(World world, int i, int j, int k, EntityHuman entityhuman) {
        int l = world.getData(i, j, k);

        if (l > 0) {
            this.e(world, i, j, k, l);
            return true;
        } else {
            return false;
        }
    }

    public void e(World world, int i, int j, int k, int l) {
        world.a((String) null, i, j, k);
        world.setData(i, j, k, 0);
        int i1 = Item.GOLD_RECORD.id + l - 1;
        float f = 0.7F;
        double d0 = (double) (world.random.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        double d1 = (double) (world.random.nextFloat() * f) + (double) (1.0F - f) * 0.2D + 0.6D;
        double d2 = (double) (world.random.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
        EntityItem entityitem = new EntityItem(world, (double) i + d0, (double) j + d1, (double) k + d2, new ItemStack(i1, 1, 0));

        entityitem.pickupDelay = 10;
        world.addEntity(entityitem);
    }

    public void dropNaturally(World world, int i, int j, int k, int l, float f) {
        if (!world.isStatic) {
            if (l > 0) {
                this.e(world, i, j, k, l);
            }

            super.dropNaturally(world, i, j, k, l, f);
        }
    }
}
