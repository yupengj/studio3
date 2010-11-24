/**
 * This file Copyright (c) 2005-2010 Aptana, Inc. This program is
 * dual-licensed under both the Aptana Public License and the GNU General
 * Public license. You may elect to use one or the other of these licenses.
 * 
 * This program is distributed in the hope that it will be useful, but
 * AS-IS and WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, TITLE, or
 * NONINFRINGEMENT. Redistribution, except as permitted by whichever of
 * the GPL or APL you select, is prohibited.
 *
 * 1. For the GPL license (GPL), you can redistribute and/or modify this
 * program under the terms of the GNU General Public License,
 * Version 3, as published by the Free Software Foundation.  You should
 * have received a copy of the GNU General Public License, Version 3 along
 * with this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Aptana provides a special exception to allow redistribution of this file
 * with certain other free and open source software ("FOSS") code and certain additional terms
 * pursuant to Section 7 of the GPL. You may view the exception and these
 * terms on the web at http://www.aptana.com/legal/gpl/.
 * 
 * 2. For the Aptana Public License (APL), this program and the
 * accompanying materials are made available under the terms of the APL
 * v1.0 which accompanies this distribution, and is available at
 * http://www.aptana.com/legal/apl/.
 * 
 * You may view the GPL, Aptana's exception and additional terms, and the
 * APL in the file titled license.html at the root of the corresponding
 * plugin containing this source file.
 * 
 * Any modifications to this file must keep this entire header intact.
 */
package com.aptana.scripting.model;

import com.aptana.core.util.SourcePrinter;

public class SmartTypingPairsElement extends AbstractBundleElement
{
	private static final char[] NO_CHARS = new char[0];
	
	private char[] _pairs;

	/**
	 * SmartTypingPairsElement
	 * 
	 * @param path
	 */
	public SmartTypingPairsElement(String path)
	{
		super(path);
	}

	/*
	 * (non-Javadoc)
	 * @see com.aptana.scripting.model.AbstractElement#getElementName()
	 */
	@Override
	protected String getElementName()
	{
		return "smart_typing_pairs"; //$NON-NLS-1$
	}

	/**
	 * getPairs
	 * 
	 * @return
	 */
	public char[] getPairs()
	{
		return _pairs;
	}

	/*
	 * (non-Javadoc)
	 * @see com.aptana.scripting.model.AbstractElement#printBody(com.aptana.core.util.SourcePrinter)
	 */
	@Override
	protected void printBody(SourcePrinter printer)
	{
		// output path, scope and pairs
		printer.printWithIndent("path: ").println(this.getPath()); //$NON-NLS-1$
		printer.printWithIndent("scope: ").println(this.getScope()); //$NON-NLS-1$
		printer.printWithIndent("pairs: ").println(this.getPairs().toString()); //$NON-NLS-1$
	}

	/**
	 * setPairs
	 * 
	 * @param pairs
	 */
	public void setPairs(String[] pairs)
	{
		if (pairs != null && pairs.length > 0)
		{
			this._pairs = new char[pairs.length];
			
			for (int i = 0; i < pairs.length; i++)
			{
				this._pairs[i] = pairs[i].charAt(0);
			}
		}
		else
		{
			this._pairs = NO_CHARS;
		}
	}
}
