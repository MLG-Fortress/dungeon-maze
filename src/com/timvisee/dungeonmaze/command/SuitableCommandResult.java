package com.timvisee.dungeonmaze.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class SuitableCommandResult {

    /** Defines whether the command description is suitable. */
    private boolean suitable = true;
    /** The command description instance. */
    private CommandDescription commandDescription;
    /** The command reference. */
    private CommandReference commandReference;
    /** The command arguments. */
    private CommandArguments commandArguments;

    /**
     * Constructor.
     *
     * @param suitable True if the command is suitable.
     * @param commandDescription The command description.
     * @param commandReference The command reference.
     * @param commandArguments The command arguments.
     */
    public SuitableCommandResult(boolean suitable, CommandDescription commandDescription, CommandReference commandReference, CommandArguments commandArguments) {
        this.suitable = suitable;
        this.commandDescription = commandDescription;
        this.commandReference = commandReference;
        this.commandArguments = commandArguments;
    }

    /**
     * Check whether the command was suitable.
     *
     * @return True if the command was suitable, false otherwise.
     */
    public boolean isSuitable() {
        return this.suitable;
    }

    /**
     * Get the command description.
     *
     * @return Command description.
     */
    public CommandDescription getCommandDescription() {
        return this.commandDescription;
    }

    /**
     * Set the command description.
     *
     * @param commandDescription The command description.
     *
     */
    public void setCommandDescription(CommandDescription commandDescription) {
        this.commandDescription = commandDescription;
    }

    /**
     * Check whether the command is executable.
     *
     * @return True if the command is executable, false otherwise.
     */
    public boolean isExecutable() {
        // Make sure the command description is valid
        if(this.commandDescription == null)
            return false;

        // Check whether the command is executable, return the result
        return this.commandDescription.isExecutable();
    }

    /**
     * Execute the command.
     *
     * @param sender The command sender that executed the command.
     *
     * @return True on success, false on failure.
     */
    public boolean executeCommand(CommandSender sender) {
        // Make sure the command description is valid
        if(this.commandDescription == null)
            return false;

        // Execute the command
        return this.commandDescription.execute(sender, this.commandReference, this.commandArguments);
    }

    /**
     * Check whether a command sender has permission to execute the command.
     *
     * @param sender The command sender.
     *
     * @return True if the command sender has permission, false otherwise.
     */
    public boolean hasPermission(CommandSender sender) {
        // Make sure the command description is valid
        if(this.commandDescription == null)
            return false;

        // Get and return the permission
        return this.commandDescription.getCommandPermissions().hasPermission(sender);
    }

    /**
     * Get the command reference.
     *
     * @return The command reference.
     */
    public CommandReference getCommandReference() {
        return this.commandReference;
    }

    /**
     * Get the command arguments.
     *
     * @return The command arguments.
     */
    public CommandArguments getCommandArguments() {
        return this.commandArguments;
    }

    public enum SuitableCommandResultType {
        OK,
        TOO_MANY_ARGUMENTS,
        TOO_LESS_ARGUMENTS,
        OTHER,
        INVALID
    }
}
