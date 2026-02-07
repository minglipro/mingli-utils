/*
 * Copyright 2026 mingliqiye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ProjectName mingli-utils
 * ModuleName mingli-utils.main
 * CurrentFile I18N.kt
 * LastUpdate 2026-02-05 22:39:07
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.i18n

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger


object I18N {

    @JvmStatic
    private var _Internationalization: Internationalization = Internationalization(
        clazz = I18N::class.java,
        objectMapper = ObjectMapper(),
        isloadSlef = true
    )

    fun setInternationalization(value: Internationalization) {
        this._Internationalization = value
    }

    fun getInternationalization() = _Internationalization

    @JvmStatic
    fun getString(string: String, vararg any: Any): String = _Internationalization.getString(string, *any)

    @JvmStatic
    fun getString(string: String): String = _Internationalization.getString(string)

    @JvmStatic
    fun getKeyString(key: String): String = _Internationalization.getKeyString(key)


    fun Logger.infoTranslater(string: String, vararg any: Any) = this.info(getString(string, *any))
    fun Logger.warnTranslater(string: String, vararg any: Any) = this.warn(getString(string, *any))
    fun Logger.debugTranslater(string: String, vararg any: Any) = this.debug(getString(string, *any))
    fun Logger.traceTranslater(string: String, vararg any: Any) = this.trace(getString(string, *any))

    // 0 个参数
    fun Logger.errorTranslater(string: String, any1: Any) {
        this.error(getString(string))
    }

    fun Logger.errorTranslater(string: String) {
        this.error(getString(string))
    }

    // 2 个参数
    fun Logger.errorTranslater(string: String, any1: Any, any2: Any) {
        this.error(getString(string, any1, any2))
    }

    // 3 个参数
    fun Logger.errorTranslater(string: String, any1: Any, any2: Any, any3: Any) {
        this.error(getString(string, any1, any2, any3))
    }

    // 4 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,

        ) {
        this.error(getString(string, any1, any2, any3, any4))
    }

    // 5 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,

        ) {
        this.error(getString(string, any1, any2, any3, any4, any5))
    }

    // 6 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,

        ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6))
    }

    // 7 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,

        ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7))
    }

    // 8 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,

        ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7, any8))
    }

    // 9 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,

        ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9))
    }

    // 10 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,

        ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10))
    }

    // 11 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any, any2: Any, any3: Any, any4: Any, any5: Any,
        any6: Any, any7: Any, any8: Any, any9: Any, any10: Any, any11: Any,

        ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11))
    }

    // 12 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any, any2: Any, any3: Any, any4: Any, any5: Any,
        any6: Any, any7: Any, any8: Any, any9: Any, any10: Any, any11: Any, any12: Any,

        ) {
        this.error(
            getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11, any12)
        )
    }

    // 13 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any, any2: Any, any3: Any, any4: Any, any5: Any,
        any6: Any, any7: Any, any8: Any, any9: Any, any10: Any, any11: Any, any12: Any, any13: Any,

        ) {
        this.error(
            getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11, any12, any13),

            )
    }

    // 14 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any, any2: Any, any3: Any, any4: Any, any5: Any,
        any6: Any, any7: Any, any8: Any, any9: Any, any10: Any, any11: Any, any12: Any, any13: Any, any14: Any,

        ) {
        this.error(
            getString(
                string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11, any12, any13, any14
            )
        )
    }

    // 15 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,

        ) {
        this.error(
            getString(
                string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11, any12, any13, any14, any15
            )
        )
    }

    // 16 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,

        ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16
            )
        )
    }

    // 17 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        any17: Any,

        ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16,
                any17
            )
        )
    }

    // 18 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        any17: Any,
        any18: Any,

        ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16,
                any17,
                any18
            )
        )
    }

    // 19 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        any17: Any,
        any18: Any,
        any19: Any,

        ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16,
                any17,
                any18,
                any19
            )
        )
    }

    // 20 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        any17: Any,
        any18: Any,
        any19: Any,
        any20: Any,
    ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16,
                any17,
                any18,
                any19,
                any20
            )
        )
    }


    fun Logger.errorTranslater(string: String, throwable: Throwable) {
        this.error(getString(string), throwable)
    }

    // 1 个参数
    fun Logger.errorTranslater(string: String, any1: Any, throwable: Throwable) {
        this.error(getString(string, any1), throwable)
    }

    // 2 个参数
    fun Logger.errorTranslater(string: String, any1: Any, any2: Any, throwable: Throwable) {
        this.error(getString(string, any1, any2), throwable)
    }

    // 3 个参数
    fun Logger.errorTranslater(string: String, any1: Any, any2: Any, any3: Any, throwable: Throwable) {
        this.error(getString(string, any1, any2, any3), throwable)
    }

    // 4 个参数
    fun Logger.errorTranslater(
        string: String, any1: Any, any2: Any, any3: Any, any4: Any, throwable: Throwable
    ) {
        this.error(getString(string, any1, any2, any3, any4), throwable)
    }

    // 5 个参数
    fun Logger.errorTranslater(
        string: String, any1: Any, any2: Any, any3: Any, any4: Any, any5: Any, throwable: Throwable
    ) {
        this.error(getString(string, any1, any2, any3, any4, any5), throwable)
    }

    // 6 个参数
    fun Logger.errorTranslater(
        string: String, any1: Any, any2: Any, any3: Any, any4: Any, any5: Any, any6: Any, throwable: Throwable
    ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6), throwable)
    }

    // 7 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        throwable: Throwable
    ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7), throwable)
    }

    // 8 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        throwable: Throwable
    ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7, any8), throwable)
    }

    // 9 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        throwable: Throwable
    ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9), throwable)
    }

    // 10 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        throwable: Throwable
    ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10), throwable)
    }

    // 11 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        throwable: Throwable
    ) {
        this.error(getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11), throwable)
    }

    // 12 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11, any12), throwable
        )
    }

    // 13 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11, any12, any13),
            throwable
        )
    }

    // 14 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(
                string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11, any12, any13, any14
            ), throwable
        )
    }

    // 15 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(
                string, any1, any2, any3, any4, any5, any6, any7, any8, any9, any10, any11, any12, any13, any14, any15
            ), throwable
        )
    }

    // 16 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16
            ), throwable
        )
    }

    // 17 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        any17: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16,
                any17
            ), throwable
        )
    }

    // 18 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        any17: Any,
        any18: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16,
                any17,
                any18
            ), throwable
        )
    }

    // 19 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        any17: Any,
        any18: Any,
        any19: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16,
                any17,
                any18,
                any19
            ), throwable
        )
    }

    // 20 个参数
    fun Logger.errorTranslater(
        string: String,
        any1: Any,
        any2: Any,
        any3: Any,
        any4: Any,
        any5: Any,
        any6: Any,
        any7: Any,
        any8: Any,
        any9: Any,
        any10: Any,
        any11: Any,
        any12: Any,
        any13: Any,
        any14: Any,
        any15: Any,
        any16: Any,
        any17: Any,
        any18: Any,
        any19: Any,
        any20: Any,
        throwable: Throwable
    ) {
        this.error(
            getString(
                string,
                any1,
                any2,
                any3,
                any4,
                any5,
                any6,
                any7,
                any8,
                any9,
                any10,
                any11,
                any12,
                any13,
                any14,
                any15,
                any16,
                any17,
                any18,
                any19,
                any20
            ), throwable
        )
    }


}
