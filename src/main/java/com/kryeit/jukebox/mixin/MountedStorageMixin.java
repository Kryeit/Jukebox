package com.kryeit.jukebox.mixin;

import com.simibubi.create.content.contraptions.MountedStorage;

import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraft.world.level.block.entity.JukeboxBlockEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = MountedStorage.class, remap = false)
public class MountedStorageMixin {

	@Inject(
			method = "canUseAsStorage",
			at = @At("HEAD"),
			cancellable = true
	)
	private static void thing(BlockEntity be, CallbackInfoReturnable<Boolean> cir) {
		if (be == null) return;

		if (be instanceof JukeboxBlockEntity) {
			cir.setReturnValue(true);
		}
	}
}
