/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.juzu.test.protocol.mock;

import org.juzu.Response;
import org.juzu.impl.spi.request.RenderBridge;

import java.io.IOException;
import java.util.Map;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class MockRenderBridge extends MockMimeBridge implements RenderBridge
{

   /** . */
   private String title;

   public MockRenderBridge(MockClient client, String methodId, Map<String, String[]> parameters)
   {
      super(client, methodId, parameters);
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   @Override
   public void setResponse(Response response) throws IllegalStateException, IOException
   {
      super.setResponse(response);
      
      //
      if (response instanceof Response.Content.Render)
      {
         Response.Content.Render stream = (Response.Content.Render)response;
         title = stream.getTitle();
      }
   }
}
