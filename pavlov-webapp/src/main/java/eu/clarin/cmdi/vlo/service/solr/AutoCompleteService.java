/*
 * Copyright (C) 2014 CLARIN
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.clarin.cmdi.vlo.service.solr;

import java.util.Iterator;

/**
 *
 * @author twagoo
 */
public interface AutoCompleteService {

    /**
     * Returns list of suggestions for incomplete input (used for autocomplete
     * function)
     *
     * @param input user input
     * @return iterator over suggestions
     */
    Iterator<String> getChoices(String input);
    
}
