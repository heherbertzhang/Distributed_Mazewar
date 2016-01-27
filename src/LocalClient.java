/*
Copyright (C) 2004 Geoffrey Alan Washburn
    
This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.
    
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
    
You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307,
USA.
*/

/**
 * An abstract class for {@link Client}s in a {@link Maze} that local to the 
 * computer the game is running upon. You may choose to implement some of 
 * your code for communicating with other implementations by overriding 
 * methods in {@link Client} here to intercept upcalls by {@link GUIClient} and 
 * {@link RobotClient} and generate the appropriate network events.
 * @author Geoffrey Washburn &lt;<a href="mailto:geoffw@cis.upenn.edu">geoffw@cis.upenn.edu</a>&gt;
 * @version $Id: LocalClient.java 343 2004-01-24 03:43:45Z geoffw $
 */


public abstract class LocalClient extends Client {

        /** 
         * Create a {@link Client} local to this machine.
         * @param name The name of this {@link Client}.
         */
         
        private BlockingQueue eventQueue = null;
        
        public LocalClient(String name, BlockingQueue eventQueue) {
                super(name);
                this.eventQueue = eventQueue;
                assert(name != null);
        }

        /**
         * Fill in here??
         
        @Override
        protected boolean forward() {
                
                if(maze.moveClientForward(this)) {
                        return true;
                } else {
                        return false;
                }
        }*/
        
        public void addActionEvent(int action){
            eventQueue.put(new MPacket(getName(), MPacket.ACTION, action));
        }
        
        public void sendKillClient(Player player){
            eventQueue.put(new MPacket(getName(), MPacket.ACTION, MPacket.DIE));
        }
}