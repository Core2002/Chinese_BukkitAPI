package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * 方块被玩家损坏的事件
 * <p>
 * 若本事件被取消，方块将不会损坏
 */
public class BlockDamageEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private boolean instaBreak;
    private boolean cancel;
    private final ItemStack itemstack;

    public BlockDamageEvent(final Player player, final Block block, final ItemStack itemInHand, final boolean instaBreak) {
        super(block);
        this.instaBreak = instaBreak;
        this.player = player;
        this.itemstack = itemInHand;
        this.cancel = false;
    }

    /**
     * 获取损坏这个方块的玩家
     *
     * @return 损坏这个方块的玩家
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 获取方块是否立即被玩家损坏
     *
     * @return 如果方块在被玩家损坏时是被立即破坏的，返回true，反之false
     *     
     */
    public boolean getInstaBreak() {
        return instaBreak;
    }

    /**
     * 设置方块是否立即被玩家损坏
     *
     * @param bool 如果你想要方块在被玩家损坏时被立即破坏，请设置true，反之false
     */
    public void setInstaBreak(boolean bool) {
        this.instaBreak = bool;
    }

    /**
     * 获取当前玩家手上的物品的ItemStack
     *
     * @return 当前玩家手上的物品的ItemStack
     */
    public ItemStack getItemInHand() {
        return itemstack;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}