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
 * CurrentFile Base256Codec.kt
 * LastUpdate 2026-03-12 10:34:36
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.base

/**
 * Base256 字符集 256个
 *
 * 256个字符 要字符集的下面复制
 *
 * !#$%&()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~§±×÷←↑→↓⇒⇔∀∃∅∆∇∈∉∋∌∏∑−∓∕∗∘∙√∛∜∞∟∠∣∥∧∨∩∪∫∬∭∮∯∰∱∲∳∴∵∶∷≈≠≡≤≥≦≧≪≫≺≻⊂⊃⊆⊇⊈⊉⊊⊋⊕⊖⊗⊘⊙⊚⊛⊜⊝⊞⊟⊠⊡⊢⊣⊤⊥⊦⊧⊨⊩⊪⊫⊬⊭⊮⊯⋀⋁⋂⋃⋄⋅⋆⋇⋈⋉⋊⋋⋌⋍⋎⋏⋐⋑⋒⋓⋔⋕⋖⋗⋘⋙⋚⋛⋜⋝⋞⋟⋠⋡⋢⋣⋤⋥⋦⋧⋨⋩▁▂▃▄▅▆▇█▉▊▋▌▍▎▏▐░▒▓▔▕▖▗▘▙
 *
 */
internal class Base256Codec : BaseCodec {

	/**
	 * 伴生对象，持有 Base256 的编码字符集及其反向索引表。
	 */
	companion object {
		/**
		 * Base256 编码字符集，共 256 个字符，数组索引即对应的字节值（0~255）。
		 */
		val code = arrayOf(
			'!',
			'#',
			'$',
			'%',
			'&',
			'(',
			')',
			'*',
			'+',
			',',
			'-',
			'.',
			'/',
			'0',
			'1',
			'2',
			'3',
			'4',
			'5',
			'6',
			'7',
			'8',
			'9',
			':',
			';',
			'<',
			'=',
			'>',
			'?',
			'@',
			'A',
			'B',
			'C',
			'D',
			'E',
			'F',
			'G',
			'H',
			'I',
			'J',
			'K',
			'L',
			'M',
			'N',
			'O',
			'P',
			'Q',
			'R',
			'S',
			'T',
			'U',
			'V',
			'W',
			'X',
			'Y',
			'Z',
			'[',
			']',
			'^',
			'_',
			'`',
			'a',
			'b',
			'c',
			'd',
			'e',
			'f',
			'g',
			'h',
			'i',
			'j',
			'k',
			'l',
			'm',
			'n',
			'o',
			'p',
			'q',
			'r',
			's',
			't',
			'u',
			'v',
			'w',
			'x',
			'y',
			'z',
			'{',
			'|',
			'}',
			'~',
			'§',
			'±',
			'×',
			'÷',
			'←',
			'↑',
			'→',
			'↓',
			'⇒',
			'⇔',
			'∀',
			'∃',
			'∅',
			'∆',
			'∇',
			'∈',
			'∉',
			'∋',
			'∌',
			'∏',
			'∑',
			'−',
			'∓',
			'∕',
			'∗',
			'∘',
			'∙',
			'√',
			'∛',
			'∜',
			'∞',
			'∟',
			'∠',
			'∣',
			'∥',
			'∧',
			'∨',
			'∩',
			'∪',
			'∫',
			'∬',
			'∭',
			'∮',
			'∯',
			'∰',
			'∱',
			'∲',
			'∳',
			'∴',
			'∵',
			'∶',
			'∷',
			'≈',
			'≠',
			'≡',
			'≤',
			'≥',
			'≦',
			'≧',
			'≪',
			'≫',
			'≺',
			'≻',
			'⊂',
			'⊃',
			'⊆',
			'⊇',
			'⊈',
			'⊉',
			'⊊',
			'⊋',
			'⊕',
			'⊖',
			'⊗',
			'⊘',
			'⊙',
			'⊚',
			'⊛',
			'⊜',
			'⊝',
			'⊞',
			'⊟',
			'⊠',
			'⊡',
			'⊢',
			'⊣',
			'⊤',
			'⊥',
			'⊦',
			'⊧',
			'⊨',
			'⊩',
			'⊪',
			'⊫',
			'⊬',
			'⊭',
			'⊮',
			'⊯',
			'⋀',
			'⋁',
			'⋂',
			'⋃',
			'⋄',
			'⋅',
			'⋆',
			'⋇',
			'⋈',
			'⋉',
			'⋊',
			'⋋',
			'⋌',
			'⋍',
			'⋎',
			'⋏',
			'⋐',
			'⋑',
			'⋒',
			'⋓',
			'⋔',
			'⋕',
			'⋖',
			'⋗',
			'⋘',
			'⋙',
			'⋚',
			'⋛',
			'⋜',
			'⋝',
			'⋞',
			'⋟',
			'⋠',
			'⋡',
			'⋢',
			'⋣',
			'⋤',
			'⋥',
			'⋦',
			'⋧',
			'⋨',
			'⋩',
			'▁',
			'▂',
			'▃',
			'▄',
			'▅',
			'▆',
			'▇',
			'█',
			'▉',
			'▊',
			'▋',
			'▌',
			'▍',
			'▎',
			'▏',
			'▐',
			'░',
			'▒',
			'▓',
			'▔',
			'▕',
			'▖',
			'▗',
			'▘',
			'▙'
		)
		/**
		 * 字符到字节值的反向映射表，用于解码时快速查找字符对应的索引。
		 */
		val codeMap = code.mapIndexed { index, c -> c to index }.toMap()
	}

	override fun encode(bytes: ByteArray): String {
		val result = CharArray(bytes.size)
		for (i in bytes.indices) {
			val unsignedByte = bytes[i].toInt() and 0xFF
			result[i] = code[unsignedByte]
		}
		return String(result)
	}

	/**
	 * 将 Base256 字符串解码为字节数组。
	 *
	 * @param string 待解码的字符串，所有字符必须属于编码字符集
	 * @return 解码后的字节数组
	 * @throws NullPointerException 如果字符串中包含字符集之外的字符
	 */
	override fun decode(string: String): ByteArray {
		val result = ByteArray(string.length)
		for (i in string.indices) {
			result[i] = codeMap[string[i]]!!.toByte()
		}
		return result
	}
}
