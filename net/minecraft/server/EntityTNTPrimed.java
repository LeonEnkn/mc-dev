package net.minecraft.server;

public class EntityTNTPrimed extends Entity {

    public int a;

    public EntityTNTPrimed(World world) {
        super(world);
        this.a = 0;
        this.aD = true;
        this.b(0.98F, 0.98F);
        this.height = this.width / 2.0F;
    }

    public EntityTNTPrimed(World world, double d0, double d1, double d2) {
        this(world);
        this.setPosition(d0, d1, d2);
        float f = (float) (Math.random() * 3.1415927410125732D * 2.0D);

        this.motX = (double) (-MathHelper.sin(f * 3.1415927F / 180.0F) * 0.02F);
        this.motY = 0.20000000298023224D;
        this.motZ = (double) (-MathHelper.cos(f * 3.1415927F / 180.0F) * 0.02F);
        this.a = 80;
        this.lastX = d0;
        this.lastY = d1;
        this.lastZ = d2;
    }

    protected void a() {}

    protected boolean l() {
        return false;
    }

    public boolean d_() {
        return !this.dead;
    }

    public void f_() {
        this.lastX = this.locX;
        this.lastY = this.locY;
        this.lastZ = this.locZ;
        this.motY -= 0.03999999910593033D;
        this.move(this.motX, this.motY, this.motZ);
        this.motX *= 0.9800000190734863D;
        this.motY *= 0.9800000190734863D;
        this.motZ *= 0.9800000190734863D;
        if (this.onGround) {
            this.motX *= 0.699999988079071D;
            this.motZ *= 0.699999988079071D;
            this.motY *= -0.5D;
        }

        if (this.a-- <= 0) {
            this.die();
            this.explode();
        } else {
            this.world.a("smoke", this.locX, this.locY + 0.5D, this.locZ, 0.0D, 0.0D, 0.0D);
        }
    }

    private void explode() {
        float f = 4.0F;

        this.world.a((Entity) null, this.locX, this.locY, this.locZ, f);
    }

    protected void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Fuse", (byte) this.a);
    }

    protected void b(NBTTagCompound nbttagcompound) {
        this.a = nbttagcompound.c("Fuse");
    }
}
