import org.eclipse.jgit.diff.DiffEntry;
public class FileHeader extends DiffEntry {
	/**
	 * Constructs a new FileHeader
	 *
	 * @param headerLines
	 *            buffer holding the diff header for this file
	 * @param edits
	 *            the edits for this file
	 * @param type
	 *            the type of patch used to modify this file
	 */
	public FileHeader(final byte[] headerLines, EditList edits, PatchType type) {
		this(headerLines, 0);
		endOffset = headerLines.length;
		int ptr = parseGitFileName(Patch.DIFF_GIT.length, headerLines.length);
		ptr = parseGitHeaders(ptr, headerLines.length);
		this.patchType = type;
		addHunk(new HunkHeader(this, edits));
	}
