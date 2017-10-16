// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package pbdi.syntax;

import pbdi.semantics.PBDIAgent;

public class PythonAtomExpr implements PythonExpr {
	String varname;
	
	public PythonAtomExpr(String varname) {
		this.varname = varname;
	}

	@Override
	public boolean evaluates_to(PBDIAgent a) {
		try {
			return (a.getState(varname) == Boolean.TRUE);
		} catch (Exception e) {
			System.err.println("Warning: No such variable in state: " + varname);
			return false;
		}
	}

}
