/*
 * Copyright The Sett Ltd, 2005 to 2014.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.thesett.aima.logic.fol.wam.builtins;

import com.thesett.aima.logic.fol.Functor;
import com.thesett.aima.logic.fol.FunctorName;
import com.thesett.aima.logic.fol.wam.compiler.DefaultBuiltIn;
import com.thesett.aima.logic.fol.wam.compiler.WAMInstruction;
import com.thesett.common.util.SizeableLinkedList;

/**
 * Implements the true atom. This always succeeds without generating any choice points.
 *
 * <pre><p/><table id="crc"><caption>CRC Card</caption>
 * <tr><th> Responsibilities <th> Collaborations
 * <tr><td> Always succeed, consuming the 'true' goal.
 * </table></pre>
 *
 * @author Rupert Smith
 */
public class True extends BaseBuiltIn
{
    /**
     * Creates a true built-in to implement the specified functor.
     *
     * @param functor        The functor to implement as a built in.
     * @param defaultBuiltIn The default built in, for standard compilation and interners and symbol tables.
     */
    public True(Functor functor, DefaultBuiltIn defaultBuiltIn)
    {
        super(functor, defaultBuiltIn);
    }

    /** {@inheritDoc} */
    public SizeableLinkedList<WAMInstruction> compileBodyArguments(Functor expression, boolean isFirstBody,
        FunctorName clauseName, int bodyNumber)
    {
        return new SizeableLinkedList<WAMInstruction>();
    }

    /** {@inheritDoc} */
    public SizeableLinkedList<WAMInstruction> compileBodyCall(Functor expression, boolean isFirstBody,
        boolean isLastBody, boolean chainRule, int permVarsRemaining)
    {
        SizeableLinkedList<WAMInstruction> result = new SizeableLinkedList<WAMInstruction>();

        if (isLastBody)
        {
            if (!chainRule)
            {
                result.add(new WAMInstruction(WAMInstruction.WAMInstructionSet.Deallocate));
            }

            result.add(new WAMInstruction(WAMInstruction.WAMInstructionSet.Proceed));
        }

        return result;
    }

    /**
     * Creates a string representation of this functor, mostly used for debugging purposes.
     *
     * @return A string representation of this functor.
     */
    public String toString()
    {
        return "True";
    }
}
